package com.developcollect.commonnotify;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public abstract class BaseNotifyResult implements INotifyResult {

    private Object rawResult;

    private List<SendResult> sendResults;

    @Override
    public String toString() {
        return "BaseNotifyResult(rawResult=" + this.getRawResult() + ", sendResults=" + this.getSendResults() + ", NotifyType=" + getNotifyType() + ")";
    }
}
