package com.x.zodo.attendance.control.jaxrs.device.v2;

import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.attendance.control.jaxrs.BaseAction;
import com.x.zodo.attendance.control.mybatisflex.Device;
import com.x.zodo.attendance.control.mybatisflex.DeviceMapper;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionHwDevice extends BaseAction {

    private static Logger logger = LoggerFactory.getLogger( ActionHwDevice.class );

    protected ActionResult<List<Wo>> execute(HttpServletRequest request, EffectivePerson effectivePerson) throws Exception {
        ActionResult<List<Wo>> result = new ActionResult<>();
        List<Device> data = mybatisFlex.getMapper(DeviceMapper.class).selectAll();
        List<Wo> copier = new ArrayList<>();
        copier = Wo.copier.copy(data, copier);
        result.setData(copier);
        return result;
    }

    public static class Wo extends Device {

        private static final List<String> includes = new ArrayList<>(
                Arrays.asList("ngId", "szName", "szType", "stDevClass", "szIpAddr", "szPlace", "ntState", "tsLastRcd")
        );
        static final WrapCopier<Device, Wo> copier = WrapCopierFactory.wo(Device.class, Wo.class, includes
                , null);
    }
}
