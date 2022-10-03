package baseball.vo.enumtype;

public enum InterfaceMsg {
    GAME_INFO("야구게임에 오신 것을 환영합니다.\n야구게임은 숫자 3개를 입력받습니다.\n만약 종료를 원하시면 2를 입력하세요 "),
    REQUEST_INPUT("숫자를 입력해주세요 : ")
    ;

    private String value;
    InterfaceMsg(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
