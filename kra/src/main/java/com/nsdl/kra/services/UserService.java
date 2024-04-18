package com.nsdl.kra.services;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsdl.kra.exceptions.DbDataMappingException;
import com.nsdl.kra.exceptions.InvalidRequestParamException;
import com.nsdl.kra.exceptions.NoDataException;
import com.nsdl.kra.helpers.Constants;
import com.nsdl.kra.model.dao.UserDao;
import com.nsdl.kra.model.dto.UserDetails;
import com.nsdl.kra.model.dto.UsersRequest;
import com.nsdl.kra.repository.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public UserDetails getUserDetails(UsersRequest usersRequest) throws Exception {

        UserDao userDao;
        if (usersRequest.validateRequest()) {
            throw new InvalidRequestParamException(Constants.INVALID_REQUEST_PARAM);
        }
        if (usersRequest.getId() != null && !usersRequest.getId().isEmpty()) {
            userDao = usersRepository.findByUserId(usersRequest.getId());
        } else if (usersRequest.getUserName() != null && !usersRequest.getUserName().isEmpty()) {
            userDao = usersRepository.findByUserName(usersRequest.getUserName());
        } else {
            throw new InvalidRequestParamException("Both ID and Username are null");
        }
        if (userDao == null) {
            throw new NoDataException("No Data Available for request");
        }
        UserDetails userDetails = Stream.of(userDao)
                .map(user -> {
                    UserDetails details = new UserDetails();
                    details.setEmailId(user.getEmailId());
                    details.setPhoneNumber(user.getPhoneNumber());
                    details.setDepartment(user.getDepartment());
                    return details;
                }).findFirst().orElseThrow(() -> new DbDataMappingException("Data Mapping failed from database"));

        return userDetails;
    }
}
