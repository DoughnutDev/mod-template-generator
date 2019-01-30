package $PACKAGE$;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLModLoadingContext;

class SideProxy {
    SideProxy() {
        $MOD_CLASS$.LOGGER.info("SideProxy init");

        // Add listeners for common events
        FMLModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLModLoadingContext.get().getModEventBus().addListener(this::imcEnqueue);
        FMLModLoadingContext.get().getModEventBus().addListener(this::imcProcess);

        // Add listeners for registry events
        FMLModLoadingContext.get().getModEventBus().addListener(ModBlocks::registerAll);
        FMLModLoadingContext.get().getModEventBus().addListener(ModItems::registerAll);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        $MOD_CLASS$.LOGGER.info("SideProxy commonSetup");
    }

    private void imcEnqueue(InterModEnqueueEvent event) {
        $MOD_CLASS$.LOGGER.info("SideProxy imcEnqueue");
    }

    private void imcProcess(InterModProcessEvent event) {
        $MOD_CLASS$.LOGGER.info("SideProxy imcProcess");
    }

    static class Client extends SideProxy {
        Client() {
            $MOD_CLASS$.LOGGER.info("SideProxy.Client init");
            FMLModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        }

        private void clientSetup(FMLClientSetupEvent event) {
            $MOD_CLASS$.LOGGER.info("SideProxy.Client clientSetup");
        }
    }

    static class Server extends SideProxy {
        Server() {
            $MOD_CLASS$.LOGGER.info("SideProxy.Server init");
            FMLModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        }

        private void serverSetup(FMLDedicatedServerSetupEvent event) {
            $MOD_CLASS$.LOGGER.info("SideProxy.Server serverSetup");
        }
    }
}
