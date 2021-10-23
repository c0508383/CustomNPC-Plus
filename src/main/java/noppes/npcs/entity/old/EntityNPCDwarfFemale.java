package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCDwarfFemale extends EntityNPCInterface
{
    public EntityNPCDwarfFemale(World world)
    {
        super(world);
        scaleX = scaleZ = 0.75f;
        scaleY = 0.6275f;
        display.texture = "customnpcs:textures/entity/dwarffemale/Simone.png";
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
