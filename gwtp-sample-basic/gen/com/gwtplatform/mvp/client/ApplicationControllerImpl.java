package com.gwtplatform.mvp.client;

import com.gwtplatform.mvp.client.ApplicationController;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class ApplicationControllerImpl implements ApplicationController {
  @Override
  public void init() {
    DelayedBindRegistry.bind(com.gwtplatform.mvp.client.ClientGinjector.SINGLETON);
    
    com.gwtplatform.mvp.client.ClientGinjector.SINGLETON.getBootstrapperImpl().onBootstrap();
  }
}
