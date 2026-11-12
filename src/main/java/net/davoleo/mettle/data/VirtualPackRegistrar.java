package net.davoleo.mettle.data;

import net.davoleo.mettle.Mettle;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@EventBusSubscriber(modid = Mettle.MODID)
public class VirtualPackRegistrar {

    @SubscribeEvent
    public static void registerVirtualPack(AddPackFindersEvent event) {
        event.addRepositorySource(VirtualRepositorySource.get());
    }

}
