package noppes.npcs.constants;

public enum EnumScriptType {
	INIT("init"),
	TICK("tick"),
	INTERACT("interact"),
	DIALOG("dialog"),
	DAMAGED("damaged"),
	KILLED("killed"),
	ATTACK_MELEE("meleeAttack"),
	TARGET("target"),
	COLLIDE("collide"),
	KILLS("kills"),
	DIALOG_OPTION("dialogOption"),
	TARGET_LOST("targetLost"),
	ROLE("role"),
	RANGED_LAUNCHED("rangedLaunched"),
	CLICKED("clicked"),
	FALLEN_UPON("fallenUpon"),
	RAIN_FILLED("rainFilled"),
	BROKEN("broken"),
	HARVESTED("harvested"),
	EXPLODED("exploded"),
	NEIGHBOR_CHANGED("neighborChanged"),
	REDSTONE("redstone"),
	DOOR_TOGGLE("doorToggle"),
	TIMER("timer"),
	TOSS("toss"),
	DROP("drop"),
	CONTAINER_OPEN("containerOpen"),
	CONTAINER_CLOSED("containerClosed"),
	LOGIN("login"),
	LOGOUT("logout"),
	CHAT("chat"),
	DAMAGED_ENTITY("damagedEntity"),
	DIALOG_CLOSE("dialogClose"),
	SPAWN("spawn"),
	TOSSED("tossed"),
	PICKEDUP("pickedUp"),
	PICKUP("pickUp"),
	ATTACK("attack"),
	PROJECTILE_TICK("projectileTick"),
	PROJECTILE_IMPACT("projectileImpact"),
	LEVEL_UP("levelUp"),
	QUEST_START("questStart"),
	QUEST_COMPLETED("questCompleted"),
	QUEST_TURNIN("questTurnIn"),
	KEY_PRESSED("keyPressed"),
	CUSTOM_CHEST_CLOSED("customChestClosed"),
	CUSTOM_CHEST_CLICKED("customChestClicked"),
	SCRIPT_COMMAND("scriptCommand"),
	CUSTOM_GUI_CLOSED("customGuiClosed"),
	CUSTOM_GUI_BUTTON("customGuiButton"),
	CUSTOM_GUI_SLOT("customGuiSlot"),
	CUSTOM_GUI_SCROLL("customGuiScroll"),
	PICKUP_XP("pickupXP"),
	MOUSE_CLICKED("mouseClicked"),
	START_USING_ITEM("startItem"),
	USING_ITEM("usingItem"),
	STOP_USING_ITEM("stopItem"),
	FINISH_USING_ITEM("finishItem"),
	FALL("fall"),
	LIGHTNING("lightning"),
	PLAYSOUND("playSound"),
	RESPAWN("respawn"),
	CHANGED_DIM("changedDim"),
	BREAK("break"),
	FORGE_INIT("forgeInit"),
	FORGE_ENTITY("forgeEntity"),
	FORGE_WORLD("forgeWorld");

	public String function;

	private EnumScriptType(String function) {
		this.function = function;
	}
}
