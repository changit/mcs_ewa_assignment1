package org.team5.bank.core.server.service.model;

import java.util.Map;

import org.team5.bank.core.server.service.ServiceException;

public interface WebService {
public Map<String,String> invokeService(Map<String,String> param) throws ServiceException;
}
