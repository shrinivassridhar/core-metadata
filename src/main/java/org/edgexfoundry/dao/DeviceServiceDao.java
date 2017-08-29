/*******************************************************************************
 * Copyright 2016-2017 Dell Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * @microservice: core-metadata
 * @author: Jim White, Dell
 * @version: 1.0.0
 *******************************************************************************/

package org.edgexfoundry.dao;

import org.edgexfoundry.domain.meta.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceServiceDao {

  @Autowired
  private DeviceServiceRepository repos;

  public DeviceService getById(String id) {
    return repos.findOne(id);
  }

  public DeviceService getByName(String name) {
    return repos.findByName(name);
  }

  public DeviceService getByIdOrName(DeviceService service) {
    if (service == null)
      return null;
    if (service.getId() != null)
      return repos.findOne(service.getId());
    if (service.getName() != null)
      return repos.findByName(service.getName());
    return null;
  }

}
