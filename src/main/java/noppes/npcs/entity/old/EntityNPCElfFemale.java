package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCElfFemale extends EntityNPCInterface
{
    public EntityNPCElfFemale(World world)
    {
        super(world);
        display.texture = "customnpcs:textures/entity/elffemale/ElfFemale.png";
		scaleX = 0.8f;
		scaleY = 1f;
		scaleZ = 0.8f;
    }


    public void onUpdate(){
    	isDead = true;

    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	ModelData data = npc.modelData;
			data.breasts = 2;
			data.legs.setScale(0.8f,1.05f);
			data.arms.setScale(0.8f,1.05f);
			data.body.setScale(0.8f,1.05f);
			data.head.setScale(0.8f,0.85f);
	    	worldObj.spawnEntityInWorld(npc);
    	}
    	super.onUpdate();
    }
}
