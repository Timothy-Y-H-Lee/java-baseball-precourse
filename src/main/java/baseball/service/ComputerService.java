package baseball.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.dto.GameNumberDto;
import baseball.vo.RuleVo;
import baseball.vo.enumtype.Inclusive;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 야구게임에서 상대방(컴퓨터)의 역할을 하는 Computer Service
 */
public class ComputerService {
    private GameNumberDto gameNumberDto;

    // start: Singleton Holder
    private ComputerService() {
    }

    private static class InnerComputerService {
        private static final ComputerService instance = new ComputerService();
    }

    public static ComputerService getInstance() {
        return InnerComputerService.instance;
    }
    // end: Singleton Holder

    /**
     * 야구게임의 숫자 3개를 새로 생성한 뒤, GameNumberDto에 저장한다.
     */
    public void initGameNumber() {
        this.gameNumberDto = GameNumberDto.builder().gameNumberList(getGameNumberList()).build();
    }

    /**
     * 야구게임의 숫자 3개를 가진 GameNumberDto를 반환
     * @return gameNumberDto : GameNumberDto
     */
    public GameNumberDto getGameNumberDto() {
        if (this.gameNumberDto == null) {
            this.initGameNumber();
        }
        return gameNumberDto;
    }

    /**
     * 야구게임에서 컴퓨터가 가진 숫자 생성
     * @return gameNumberList : List<Integer>
     */
    private List<Integer> getGameNumberList() {
        final Set<Integer> gameNumberSet = new HashSet<>();

        do {
            gameNumberSet.add(Randoms.pickNumberInRange(Inclusive.START.getValue(), Inclusive.END.getValue()));
        } while (gameNumberSet.size() < RuleVo.getGameNumbersLen());

        return new ArrayList<>(gameNumberSet);
    }
}
