package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCElfMale extends EntityNPCInterface
{
    public EntityNPCElfMale(World world)
    {
        super(world);
		scaleX = 0.85f;
		scaleY = 1.07f;
		scaleZ = 0.85f;
		display.texture = "customnpcs:textures/entity/elfmale/ElfMale.png";
    }


    public void onUpdate(){
    	isDead = true;

    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	ModelData data = npc.modelData;
			data.legs.setScale(0.85f,1.15f);
			data.arms.setScale(0.85f,1.15f);
			data.body.setScale(0.85f,1.15f);
			data.head.setScale(0.85f,0.95f);
	    	worldObj.spawnEntityInWorld(npc);
    	}
    	super.onUpdate();
    }
}
