package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCDwarfMale extends EntityNPCInterface
{
    public EntityNPCDwarfMale(World world)
    {
        super(world);
        scaleX = scaleZ = 0.85f;
        scaleY = 0.6875f;
        display.texture = "customnpcs:textures/entity/dwarfmale/Simon.png";
    }

    public void onUpdate(){
    	isDead = true;

    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	ModelData data = npc.modelData;
			data.legs.setScale(1.1f,0.7f, 0.9f);
			data.arms.setScale(0.9f,0.7f);
			data.body.setScale(1.2f, 0.7f, 1.5f);
			data.head.setScale(0.85f,0.85f);
	    	worldObj.spawnEntityInWorld(npc);
    	}
    	super.onUpdate();
    }
}
