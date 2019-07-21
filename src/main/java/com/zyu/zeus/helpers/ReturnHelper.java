package com.zyu.zeus.helpers;

import com.alibaba.fastjson.JSONObject;
import com.zyu.zeus.define.IOutput;
import com.zyu.zeus.define.ReturnCode;
import com.zyu.zeus.utils.JsonUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/5/25 22:17
 */
@Component
public class ReturnHelper {
    @Resource
    private MessageSource messageBundle;

    private JSONObject defaultSuccessOutput;
    private JSONObject defaultFailureOutput;

    public JSONObject success() {
        if (defaultSuccessOutput == null) {
            defaultSuccessOutput = toOutputJson(ReturnCode.OK);
        }

        return defaultSuccessOutput;
    }

    public JSONObject success(ReturnCode returnCode) {
        return success(returnCode, null, null);
    }

    public JSONObject success(IOutput returnContent) {
        return success(ReturnCode.OK, returnContent);
    }


    public JSONObject success(ReturnCode returnCode, Object[] errmsgArgs) {
        return success(returnCode, errmsgArgs, null);
    }

    public JSONObject success(ReturnCode returnCode, IOutput returnContent) {
        return success(returnCode, null, returnContent);
    }

    public JSONObject success(ReturnCode returnCode, JSONObject returnContent) {
        JSONObject ret = new JSONObject();

        ret.put("errcode", returnCode.getErrcode());
        ret.put("errmsg", "");
        ret.put("data", returnContent);
        return ret;

    }


    public JSONObject success(ReturnCode returnCode, Object[] errmsgArgs, IOutput returnContent) {
        return toOutputJson(returnCode, errmsgArgs, returnContent);
    }

    public JSONObject failure() {
        if (defaultFailureOutput == null) {
            defaultFailureOutput = toOutputJson(ReturnCode.EX);
        }

        return defaultFailureOutput;
    }

    public JSONObject failure(ReturnCode returnCode) {
        return failure(returnCode, null);
    }

    public JSONObject failure(ReturnCode returnCode, Object errMsgArg) {
        return failure(returnCode, new Object[]{errMsgArg});
    }

    public JSONObject failure(ReturnCode returnCode, Object[] errmsgArgs) {
        return toOutputJson(returnCode, errmsgArgs);
    }

    public JSONObject failureWithOutput(ReturnCode returnCode, IOutput returnContent) {
        return toOutputJson(returnCode, null, returnContent);
    }

    private JSONObject toOutputJson(ReturnCode returnCode) {
        return toOutputJson(returnCode, null);
    }

    private JSONObject toOutputJson(ReturnCode returnCode, Object[] errmsgArgs) {
        return toOutputJson(returnCode, errmsgArgs, null);
    }

    private JSONObject toOutputJson(ReturnCode returnCode, Object[] errmsgArgs, IOutput returnContent) {
        JSONObject ret = JsonUtil.toJson(JsonUtil.toJsonString(returnContent));

        if (ret == null) {
            ret = new JSONObject();
        }

        ret.put("errcode", returnCode.getErrcode());
        String errmsgKey = returnCode.getErrmsgKey();

        String errmsg = messageBundle.getMessage(errmsgKey, errmsgArgs, LocaleContextHolder.getLocale());

        ret.put("errmsg", errmsg);

        return ret;
    }

    public JSONObject toOutputJson(ReturnCode returnCode, Object[] errmsgArgs, Object object) {
        JSONObject ret = JsonUtil.toJson(JsonUtil.toJsonString(object));

        if (ret == null) {
            ret = new JSONObject();
        }

        ret.put("errcode", returnCode.getErrcode());
        String errmsgKey = returnCode.getErrmsgKey();
        String errmsg = messageBundle.getMessage(errmsgKey, errmsgArgs, LocaleContextHolder.getLocale());
        ret.put("errmsg", errmsg);

        return ret;
    }
    public JSONObject toOutputJson(ReturnCode returnCode, Object[] errmsgArgs, Object object,String log) {
        JSONObject ret = JsonUtil.toJson(JsonUtil.toJsonString(object));

        if (ret == null) {
            ret = new JSONObject();
        }

        ret.put("errcode", returnCode.getErrcode());
        String errmsgKey = returnCode.getErrmsgKey();
        String errmsg = messageBundle.getMessage(errmsgKey, errmsgArgs, LocaleContextHolder.getLocale());
        ret.put("errmsg", errmsg);
        ret.put("log", log);

        return ret;
    }

}
