package net.yaboiiii_xd.firstmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent YUZU = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(1.9f)
            .build();
    public static final FoodComponent LEGENDARY_YUZU = new FoodComponent.Builder()
            .nutrition(20)
            .saturationModifier(20f)
            .build();
    public static final FoodComponent JALAPENO = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(3.5f)
            .build();
}
