package noppes.npcs;

import java.util.Collection;
import java.util.List;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.data.Line;
import noppes.npcs.controllers.data.Lines;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;
import org.lwjgl.Sys;

public class VersionCompatibility {
	public static int ModRev = 19;

	public static void CheckNpcCompatibility(EntityNPCInterface npc, NBTTagCompound compound){
		if(npc.npcVersion == ModRev)
			return;
		if(npc.npcVersion < 19){
			// Fix 64-Textures
			String texture = compound.getString("Texture");
			texture = texture.replace("64-Textures/", "");
			compound.setString("Texture", texture);

			if (compound.hasKey("CanDrown")) {
				compound.setInteger("DrowningType", (compound.getBoolean("CanDrown") ? 1 : 0));
				compound.removeTag("CanDrown");
			}

		}
		if(npc.npcVersion < 18){
			// Fix CloakTexture (Reorganization)
			String cloakTexture = compound.getString("CloakTexture");
			cloakTexture = cloakTexture.replace("/cloak/Daybreak/", "/cloak/Guilds/Daybreak/");
			cloakTexture = cloakTexture.replace("/cloak/Created/", "/cloak/Extras/");
			cloakTexture = cloakTexture.replace("/cloak/Color Capes/", "/cloak/Color/");
			compound.setString("CloakTexture", cloakTexture);
		}
		if(npc.npcVersion < 17){
			// Fix DialogDarkenScreen
			if(compound.hasKey("DialogDarkenScreen")){
				compound.removeTag("DialogDarkenScreen");
			}
		}
		if(npc.npcVersion < 12){
			CompatabilityFix(compound, npc.advanced.writeToNBT(new NBTTagCompound()));
			CompatabilityFix(compound, npc.ai.writeToNBT(new NBTTagCompound()));
			CompatabilityFix(compound, npc.stats.writeToNBT(new NBTTagCompound()));
			CompatabilityFix(compound, npc.display.writeToNBT(new NBTTagCompound()));
			CompatabilityFix(compound, npc.inventory.writeEntityToNBT(new NBTTagCompound()));
		}
		if(npc.npcVersion < 5){
			String texture = compound.getString("Texture");
			texture = texture.replace("/mob/customnpcs/", "customnpcs:textures/entity/");
			texture = texture.replace("/mob/", "customnpcs:textures/entity/");
			compound.setString("Texture", texture);
		}
		if(npc.npcVersion < 6 && compound.getTag("NpcInteractLines") instanceof NBTTagList){
			List<String> interactLines = NBTTags.getStringList(compound.getTagList("NpcInteractLines", 10));
			Lines lines = new Lines();
			for(int i = 0; i < interactLines.size(); i++){
				Line line = new Line();
				line.text = (String) interactLines.toArray()[i];
				lines.lines.put(i, line);
			}
			compound.setTag("NpcInteractLines", lines.writeToNBT());

			List<String> worldLines = NBTTags.getStringList(compound.getTagList("NpcLines", 10));
			lines = new Lines();
			for(int i = 0; i < worldLines.size(); i++){
				Line line = new Line();
				line.text = (String) worldLines.toArray()[i];
				lines.lines.put(i, line);
			}
			compound.setTag("NpcLines", lines.writeToNBT());

			List<String> attackLines = NBTTags.getStringList(compound.getTagList("NpcAttackLines", 10));
			lines = new Lines();
			for(int i = 0; i < attackLines.size(); i++){
				Line line = new Line();
				line.text = (String) attackLines.toArray()[i];
				lines.lines.put(i, line);
			}
			compound.setTag("NpcAttackLines", lines.writeToNBT());

			List<String> killedLines = NBTTags.getStringList(compound.getTagList("NpcKilledLines", 10));
			lines = new Lines();
			for(int i = 0; i < killedLines.size(); i++){
				Line line = new Line();
				line.text = (String) killedLines.toArray()[i];
				lines.lines.put(i, line);
			}
			compound.setTag("NpcKilledLines", lines.writeToNBT());

		}
		if(npc.npcVersion == 12){
			NBTTagList list = compound.getTagList("StartPos", 3);
			if(list.tagCount() == 3){
				int z = ((NBTTagInt) list.removeTag(2)).func_150287_d();
				int y = ((NBTTagInt) list.removeTag(1)).func_150287_d();
				int x = ((NBTTagInt) list.removeTag(0)).func_150287_d();
				
				compound.setIntArray("StartPosNew", new int[]{x,y,z});
			}
		}
		if(npc.npcVersion == 13){
			boolean bo = compound.getBoolean("HealthRegen");
			compound.setInteger("HealthRegen", bo?1:0);
			NBTTagCompound comp = compound.getCompoundTag("TransformStats");
			bo = comp.getBoolean("HealthRegen");
			comp.setInteger("HealthRegen", bo?1:0);
    		compound.setTag("TransformStats", comp);
			
		}
		npc.npcVersion = ModRev;
	}

	public static void CheckModelCompatibility(EntityNPCInterface npc, NBTTagCompound compound){
		if(npc.npcVersion == ModRev)
			return;
		if(npc.npcVersion < 19) {
			NBTTagCompound partData = compound.getCompoundTag("NpcModelData");

			// Fix Leg MPM Dependency
			if(partData.hasKey("LegParts")){
				NBTTagCompound legParts = partData.getCompoundTag("LegParts");
				if(legParts.hasKey("Texture")){
					legParts.setString("Texture", legParts.getString("Texture").replace("moreplayermodels:textures", "customnpcs:textures/parts"));
				}
				partData.setTag("LegParts", legParts);
			}

			// Fix Part MPM Dependency
			if(partData.hasKey("Parts")){
				NBTTagList list = partData.getTagList("Parts", 10);

				for (int i = 0; i < list.tagCount(); i++) {
					NBTTagCompound item = list.getCompoundTagAt(i);

					if(item.hasKey("Texture")){
						item.setString("Texture", item.getString("Texture").replace("moreplayermodels:textures", "customnpcs:textures/parts"));
					}
					list.func_150304_a(i, item);
				}
				partData.setTag("Parts", list);
			}
			compound.setTag("NpcModelData", partData);
		}
	}

	public static void CheckAvailabilityCompatibility(ICompatibilty compatibilty, NBTTagCompound compound){
		if(compatibilty.getVersion() == ModRev)
			return;
		CompatabilityFix(compound, compatibilty.writeToNBT(new NBTTagCompound()));
		
		compatibilty.setVersion(ModRev);
	}
	private static void CompatabilityFix(NBTTagCompound compound,
			NBTTagCompound check) {
		Collection<String> tags = check.func_150296_c();
		for(String name : tags){
			NBTBase nbt = check.getTag(name);
			if(!compound.hasKey(name)){
				compound.setTag(name, nbt);
			}
			else if(nbt instanceof NBTTagCompound && compound.getTag(name) instanceof NBTTagCompound){
				CompatabilityFix(compound.getCompoundTag(name), (NBTTagCompound)nbt);
			}
		}
	}
}
