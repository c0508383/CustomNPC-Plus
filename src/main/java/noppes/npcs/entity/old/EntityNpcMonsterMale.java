package noppes.npcs.entity.old;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNpcMonsterMale extends EntityNPCInterface
{
    public EntityNpcMonsterMale(World world)
    {
        super(world);
        display.texture = "customnpcs:textures/entity/monstermale/ZombieSteve.png";
    }
    
    public void onUpdate(){
    	isDead = true;

    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	npc.ai.animationType = EnumAnimation.HUG;
	    	worldObj.spawnEntityInWorld(npc);
    	}
    	super.onUpdate();
    }

}
