package noppes.npcs.client.gui.util;

public interface IGui {
    int getID();

    void drawScreen(int var1, int var2);

    void updateScreen();

    boolean isActive();
}
