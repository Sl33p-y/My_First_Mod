package net.yaboiiii_xd.firstmod.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.yaboiiii_xd.firstmod.FirstMod;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

        public static final RegistryEntry<ArmorMaterial> MORTEMITE = register("mortemite", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 5);
            map.put(ArmorItem.Type.LEGGINGS, 8);
            map.put(ArmorItem.Type.CHESTPLATE, 10);
            map.put(ArmorItem.Type.HELMET, 5);
            map.put(ArmorItem.Type.BODY, 28);
        }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5F, 0.5F, () -> Ingredient.ofItems(ModItems.MORTEMITE));

        private static RegistryEntry<ArmorMaterial> register(
                String id,
                EnumMap<ArmorItem.Type, Integer> defense,
                int enchantability,
                RegistryEntry<SoundEvent> equipSound,
                float toughness,
                float knockbackResistance,
                Supplier<Ingredient> repairIngredient
        ) {
            List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(new Identifier(FirstMod.MOD_ID, id)));
            return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
        }

        private static RegistryEntry<ArmorMaterial> register(
                String id,
                EnumMap<ArmorItem.Type, Integer> defense,
                int enchantability,
                RegistryEntry<SoundEvent> equipSound,
                float toughness,
                float knockbackResistance,
                Supplier<Ingredient> repairIngredient,
                List<ArmorMaterial.Layer> layers
        ) {
            EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

            for (ArmorItem.Type type : ArmorItem.Type.values()) {
                enumMap.put(type, (Integer)defense.get(type));
            }

            return Registry.registerReference(
                    Registries.ARMOR_MATERIAL,
                    new Identifier(id),
                    new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
            );
        }
    }
