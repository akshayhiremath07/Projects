package com.getitdone.dao;

import com.getitdone.bo.CustomerBo;

public interface ICustomerDao {
  public String save(CustomerBo bo) throws Exception;
}
