package noppes.npcs.scripted.interfaces.handler;

public interface IPlayerDialogData {

    boolean hasReadDialog(int id);

    void readDialog(int id);

    void unreadDialog(int id);
}
