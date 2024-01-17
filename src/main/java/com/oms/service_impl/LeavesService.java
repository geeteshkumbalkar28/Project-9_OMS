package com.oms.service_impl;



import com.oms.Entity.Leaves;
import com.oms.dto.LeavesDto;
import com.oms.exceptions.InterviewNotFoundException;
import com.oms.exceptions.LeavesNotFoundException;
import com.oms.repositories.LeavesRepository;
import com.oms.service.LeavesInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeavesService implements LeavesInterface {

        private final LeavesRepository leavesRepository;
    @Override
    public String addLeaves(LeavesDto leavesDto) {

        Leaves leaves = new Leaves();
        leaves.setLeaveType(leavesDto.leaveType);
        leaves.setStatus(leavesDto.status);
        leaves.setNoOfLeave(leavesDto.noOfLeave);

        leavesRepository.save(leaves);

        return "Leaves  added succesfully";
    }



    @Override
    public Leaves getLeaves(Integer leaveId) {
        Optional<Leaves> leavesController  = leavesRepository.findById(leaveId);
        if(leavesController.isEmpty()){throw new LeavesNotFoundException("Leaves not found by Id");
        }
        return leavesController.get();
    }

    @Override
    public String deleteleave(Integer leaveId) {
        Optional<Leaves> leavesController = leavesRepository.findById(leaveId);
        if(leavesController.isEmpty()){throw new InterviewNotFoundException("Interview not found by Id");
        }
        leavesRepository.deleteById(leaveId);
        return "deleted leaves";
    }

    @Override
    public List<Leaves> getallLeave(Integer leaveId) {
        return leavesRepository.findAll();
    }
}
