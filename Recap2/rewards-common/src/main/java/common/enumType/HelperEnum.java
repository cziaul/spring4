package common.enumType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HelperEnum {

	public void log(final Map<?, ?> map) {

		for (final Object key : map.keySet()) {

			//log(String.format("%s = [%s]", key, map.get(key)));
			System.out.println(String.format("%s = [%s]", key, map.get(key)));

		}

	}

	public enum AgreementStatus {

		STATUS_PENDING(MetaDataIDConstants.STATUS_PENDING),

		STATUS_INACTIVE(MetaDataIDConstants.STATUS_INACTIVE),

		STATUS_ACTIVE(MetaDataIDConstants.STATUS_ACTIVE);

		private String value;

		static public List<AgreementStatus> types = new ArrayList<AgreementStatus>();

		static {

			types.addAll(Arrays.asList(STATUS_PENDING, STATUS_INACTIVE, STATUS_ACTIVE));

		}

		private AgreementStatus(String value) {

			this.value = value;

		}

		public String getValue() {

			return value;

		}

		public String toString() {

			return value;

		}

		public static AgreementStatus findByValue(String value) {

			AgreementStatus type = null;

			for (AgreementStatus checkType : types) {

				if (checkType.getValue().equals(value)) {

					type = checkType;

					break;

				}

			}

			return type;

		}

		public static AgreementStatus findByName(String name) {

			if ((name == null) || (name.trim().length() == 0)) {

				return null;

			}

			return Enum.valueOf(AgreementStatus.class, name);

		}

	}

}
