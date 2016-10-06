package by.htp.library.service;

import by.htp.library.service.exception.ServiceException;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by oxothuk1401 on 03.10.2016.
 */
public class ValidatorTest {
    @Test(expected = ServiceException.class)
    public void loginValidator() throws Exception {
        assertNotNull(UserService.Validator.loginValidator("",""));
    }
    @Test(expected = ServiceException.class)
    public void registValidator() throws Exception {
        assertNotNull(RegisterService.Validator.registerValidator("",""));
    }
    @Test(expected = ServiceException.class)
    public void searchValidator() throws Exception {
        assertNotNull(SearchService.Validator.searchValidator(""));
    }


}