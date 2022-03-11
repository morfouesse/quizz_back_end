package com.antoine.quizz.service.loggerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements ILoggerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerServiceImpl.class);

    @Override
    public void loggerInfo(String apiVersionClient) {
        LOGGER.info(apiVersionClient);
    }
}
