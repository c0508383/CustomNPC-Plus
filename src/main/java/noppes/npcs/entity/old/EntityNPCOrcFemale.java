package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCOrcFemale extends EntityNPCInterface
{
    public EntityNPCOrcFemale(World world)
    {
        super(world);
		scaleX = scaleY = scaleZ = 0.9375f;
		display.texture = "customnpcs:textures/entity/orcfemale/StrandedFemaleOrc.png";
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
			data.legs.setScale(0.9f,0.65f);
			data.arms.setScale(0.9f,0.65f);
			data.body.setScale(1f, 0.65f, 1.1f);
			data.head.setScale(0.85f,0.85f);
	    	worldObj.spawnEntityInWorld(npc);
    	}
    	super.onUpdate();
    }
}
