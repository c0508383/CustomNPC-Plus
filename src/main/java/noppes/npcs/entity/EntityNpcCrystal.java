package noppes.npcs.entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;

public class EntityNpcCrystal extends EntityNPCInterface
{
    public EntityNpcCrystal(World world)
    {
        super(world);
		scaleX = 0.7f;
		scaleY = 0.7f;
		scaleZ = 0.7f;
		display.texture = "customnpcs:textures/entity/crystal/EnderCrystal.png";
    }
    
    @Override
    public void onUpdate()
    {
    	isDead = true;
    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	ModelData data = npc.modelData;
			data.setEntityClass(EntityNpcCrystal.class);
	    	
	    	
	    	worldObj.spawnEntityInWorld(npc);
    	}
        super.onUpdate();
    }

}
