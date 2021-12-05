package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.ModelPartData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCFurryMale extends EntityNPCInterface
{
    public EntityNPCFurryMale(World world)
    {
        super(world);
        display.texture = "customnpcs:textures/entity/furrymale/WolfGrey.png";
    }
    
    public void onUpdate()
    {
    	isDead = true;

    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	ModelData data = npc.modelData;
	    	ModelPartData hair = data.getOrCreatePart("ears");
			hair.playerTexture = true;
			ModelPartData snout = data.getOrCreatePart("snout");
			snout.playerTexture = true;
			snout.type = 1;
			ModelPartData tail = data.getOrCreatePart("tail");
			tail.playerTexture = true;
	    	
	    	
	    	worldObj.spawnEntityInWorld(npc);
    	}
        super.onUpdate();
    }

}
