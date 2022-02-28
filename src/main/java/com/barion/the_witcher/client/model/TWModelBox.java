package com.barion.the_witcher.client.model;

import com.github.alexthe666.citadel.client.model.AdvancedEntityModel;
import com.github.alexthe666.citadel.client.model.AdvancedModelBox;

public class TWModelBox extends AdvancedModelBox {
    public TWModelBox(AdvancedEntityModel model, String name) {super(model, name);}
    public TWModelBox(AdvancedEntityModel model) {super(model);}
    public TWModelBox(AdvancedEntityModel model, int textureOffsetX, int textureOffsetY) {super(model, textureOffsetX, textureOffsetY);}

    @Override
    public TWModelBox addBox(float x, float y, float z, float sizeX, float sizeY, float sizeZ){
        return (TWModelBox)super.addBox(x, y, z, sizeX, sizeY, sizeZ);
    }

    public void addBox(float x, float y, float z, float sizeX, float sizeY, float sizeZ, float deformation){
        super.addBox(x, y, z, sizeX, sizeY, sizeZ, deformation);
        //return this;
    }

    @Override
    public TWModelBox setTextureOffset(int x, int y) {
        return (TWModelBox) super.setTextureOffset(x, y);
    }

    public TWModelBox setRotationDeg(float x, float y, float z){
        return setRotationRad((float)Math.toRadians(x), (float)Math.toRadians(y), (float)Math.toRadians(z));
    }

    public TWModelBox setRotationRad(float x, float y, float z){
        rotateAngleX = x;
        rotateAngleY = y;
        rotateAngleZ = z;
        return this;
    }

    @Override
    public void setRotationPoint(float x, float y, float z) {
        super.setRotationPoint(x, y, z);
    }
}