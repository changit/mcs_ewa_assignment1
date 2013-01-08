/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.axis2.transport.testkit.doclet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResourceInfo implements Serializable {
    private static final long serialVersionUID = -3590562573639276912L;
    
    private final Map<String,Resource> resources = new HashMap<String,Resource>();
    
    public void addResource(Resource resource) {
        resources.put(resource.getType(), resource);
    }
    
    public Resource getResource(String type) {
        return resources.get(type);
    }
    
    public List<Resource> getUsedBy(String type) {
        List<Resource> result = null;
        for (Resource resource : resources.values()) {
            List<Dependency> dependencies = resource.getDependencies();
            if (dependencies != null) {
                for (Dependency dependency : dependencies) {
                    if (dependency.getType().equals(type)) {
                        if (result == null) {
                            result = new LinkedList<Resource>();
                        }
                        result.add(resource);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
