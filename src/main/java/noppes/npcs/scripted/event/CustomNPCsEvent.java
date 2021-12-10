package noppes.npcs.scripted.event;

import cpw.mods.fml.common.eventhandler.Event;
import noppes.npcs.scripted.NpcAPI;

public class CustomNPCsEvent extends Event{
    public final NpcAPI API = NpcAPI.Instance();

    public CustomNPCsEvent() {
    }
}
