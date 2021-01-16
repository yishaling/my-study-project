package rocketmq.productor;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Thanks
 */
public class PayRefundDto {
    //申请退款金额 单位: 分
    @Min(value = 1,message = "退款金额至少为1分")
    private Integer refundFree=1;
    //订单总金额  单位:  分
    @Min(value = 1,message = "订单总金额至少为1分")
    private Integer totalFree=1;

    //退款校区
    @Min(value = 0L,message = "退款校区ID不能为空")
    private Long schoolArea=1L;

    @NotBlank(message = "退款订单号不能为空")
    private String orderNo="111";

    //申请退款人ID  如果自动退款则默认为1
    private String requestApplyUserId="1";
    //退款申请人姓名  如果是自动退款则默认为system
    private String requestApplyUserName="system";

    @NotBlank(message = "申请退款原因不能为空")
    private String refundReason="拼团失败-系统自动退款";

    //校区名称
    private String schoolName="schoolName";


    public Integer getRefundFree() {
        return refundFree;
    }

    public void setRefundFree(Integer refundFree) {
        this.refundFree = refundFree;
    }

    public Integer getTotalFree() {
        return totalFree;
    }

    public void setTotalFree(Integer totalFree) {
        this.totalFree = totalFree;
    }

    public Long getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(Long schoolArea) {
        this.schoolArea = schoolArea;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRequestApplyUserId() {
        return requestApplyUserId;
    }

    public void setRequestApplyUserId(String requestApplyUserId) {
        this.requestApplyUserId = requestApplyUserId;
    }

    public String getRequestApplyUserName() {
        return requestApplyUserName;
    }

    public void setRequestApplyUserName(String requestApplyUserName) {
        this.requestApplyUserName = requestApplyUserName;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "PayRefundDto{" +
                "refundFree=" + refundFree +
                ", totalFree=" + totalFree +
                ", schoolArea=" + schoolArea +
                ", orderNo='" + orderNo + '\'' +
                ", requestApplyUserId='" + requestApplyUserId + '\'' +
                ", requestApplyUserName='" + requestApplyUserName + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
