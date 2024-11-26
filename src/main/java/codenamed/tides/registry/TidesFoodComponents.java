package codenamed.tides.registry;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Items;

public class TidesFoodComponents {

    public static final FoodComponent OCEAN_STEW = createStew(6).build();

    private static FoodComponent.Builder createStew(int hunger) {
        return (new FoodComponent.Builder()).nutrition(hunger).saturationModifier(0.6F).usingConvertsTo(Items.BOWL);
    }
}
