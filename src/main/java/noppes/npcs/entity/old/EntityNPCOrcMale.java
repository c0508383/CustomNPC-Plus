package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCOrcMale extends EntityNPCInterface
{
    public EntityNPCOrcMale(World world)
    {
        super(world);
		scaleY = 1f;
		scaleX = scaleZ = 1.2f;
        display.texture = "customnpcs:textures/entity/orcmale/StrandedOrc.png";
    }

    public void onUpdate(){
    	isDead = true;

    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	ModelData data = npc.modelData;
			data.legs.setScale(1.2f,1.05f);
			data.arms.setScale(1.2f,1.05f);
			data.body.setScale(1.4f, 1.1f, 1.5f);
			data.head.setScale(1.2f,1.1f);
	    	worldObj.spawnEntityInWorld(npc);
    	}
    	super.onUpdate();
    }
}
