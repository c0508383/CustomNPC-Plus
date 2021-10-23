package noppes.npcs.controllers.data;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EventHooks;
import noppes.npcs.EventScriptContainer;
import noppes.npcs.NBTTags;
import noppes.npcs.constants.EnumScriptType;
import noppes.npcs.controllers.IScriptHandler;
import noppes.npcs.controllers.ScriptController;
import noppes.npcs.scripted.wrapper.WrapperNpcAPI;

import javax.script.ScriptEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ForgeDataScript implements IScriptHandler {
    private List<EventScriptContainer> scripts = new ArrayList();
    private String scriptLanguage = "ECMAScript";
    public long lastInited = -1L;
    private boolean enabled = false;

    public ForgeDataScript() {
    }

    public void clear() {
        this.scripts = new ArrayList();
    }

    public void readFromNBT(NBTTagCompound compound) {
        this.scripts = NBTTags.GetScript(compound.getTagList("Scripts", 10), this);
        this.scriptLanguage = compound.getString("ScriptLanguage");
        this.enabled = compound.getBoolean("ScriptEnabled");
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("Scripts", NBTTags.NBTScript(this.scripts));
        compound.setString("ScriptLanguage", this.scriptLanguage);
        compound.setBoolean("ScriptEnabled", this.enabled);
        return compound;
    }

    @Override
    public void callScript(EnumScriptType var1, Event var2, Object... obs) {
        callScript(var1.function, var2);
    }

    public void callScript(String type, Event event) {
        if(this.isEnabled()) {
            //Minecraft.getMinecraft().func_152344_a(() -> {
                if (ScriptController.Instance.lastLoaded > this.lastInited) {
                    this.lastInited = ScriptController.Instance.lastLoaded;
                    if (!type.equals("init")) {
                        EventHooks.onForgeInit(this);
                    }
                }

            for (EventScriptContainer script : this.scripts) {
                script.setEngine(scriptLanguage);
                if (script.engine == null)
                    return;

                Event result = (Event) script.engine.get("event");
                if (result == null)
                    script.engine.put("event", event);
                script.engine.put("API", new WrapperNpcAPI());

                ScriptEngine engine = script.engine;

                script.run(type, event);
            }
            //});
        }
    }

    public boolean isEnabled() {
        return this.enabled && ScriptController.HasStart && this.scripts.size() > 0;
    }

    public boolean isClient() {
        return false;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean bo) {
        this.enabled = bo;
    }

    public String getLanguage() {
        return this.scriptLanguage;
    }

    public void setLanguage(String lang) {
        this.scriptLanguage = lang;
    }

    public List<EventScriptContainer> getScripts() {
        return this.scripts;
    }

    public String noticeString() {
        return "ForgeScript";
    }

    public Map<Long, String> getConsoleText() {
        TreeMap map = new TreeMap();
        int tab = 0;

        for (EventScriptContainer script : this.getScripts()) {
            ++tab;

            for (Entry<Long, String> longStringEntry : script.console.entrySet()) {
                Entry entry = (Entry) longStringEntry;
                map.put(entry.getKey(), " tab " + tab + ":\n" + (String) entry.getValue());
            }
        }

        return map;
    }

    public void clearConsole() {

        for (EventScriptContainer script : this.getScripts()) {
            script.console.clear();
        }

    }
}
