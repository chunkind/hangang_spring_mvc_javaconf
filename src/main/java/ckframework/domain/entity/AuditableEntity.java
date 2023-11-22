package ckframework.domain.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import ckframework.persistent.mybatis.audit.AuditInfo;

/**
 * 검증 규칙: AuditableEntity 의 모든 속성은 Mybatis(+ Mybatis Interceptor) 에 의해서만 값이 Setting 된다. 따라서 모든 값은 사용자로부터 입력받아서는 않된다.
 * @author narusas
 */

@MappedSuperclass
@Getter
@Setter
@SuppressWarnings("serial")
public abstract class AuditableEntity implements Serializable {
	public abstract void setupAudit(AuditInfo auditInfo);

}
