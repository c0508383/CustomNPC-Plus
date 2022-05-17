package noppes.npcs.scripted;

import noppes.npcs.scripted.interfaces.ISkinOverlay;

public class ScriptSkinOverlay implements ISkinOverlay {
    public String texture;
    public boolean glow;
    public float alpha = 1.0F;

    public ScriptSkinOverlay(String texture) {
        this.texture = texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
    public String getTexture() {
        return texture;
    }

    public void setGlow(boolean glow) {
        this.glow = glow;
    }
    public boolean getGlow() {
        return glow;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
    public float getAlpha() {
        return alpha;
    }
}