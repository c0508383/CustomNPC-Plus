package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.ModelPartData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCFurryFemale extends EntityNPCInterface
{
    public EntityNPCFurryFemale(World world)
    {
        super(world);
        scaleX = scaleY = scaleZ = 0.9075f;
        display.texture = "customnpcs:textures/entity/furryfemale/WolfBlack.png";
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
			data.breasts = 2;
			data.head.setScale(0.95f,0.95f);
			data.legs.setScale(0.92f,0.92f);
			data.arms.setScale(0.80f,0.92f);
			data.body.setScale(0.92f, 0.92f);
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
