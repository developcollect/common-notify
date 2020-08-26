package com.developcollect.commonnotify;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public abstract class BaseNotifyResult implements INotifyResult {

    private List<SendResult> sendResults;

}
