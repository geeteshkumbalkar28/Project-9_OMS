package com.oms.service;



import com.oms.Entity.Leaves;
import com.oms.dto.LeavesDto;

import java.util.List;


public interface LeavesInterface {
    public String addLeaves(LeavesDto leavesDto);
    public Leaves getLeaves(Integer leaveId);
    public String deleteleave(Integer leaveId);
    public List<Leaves> getallLeave(Integer leaveId);


}
