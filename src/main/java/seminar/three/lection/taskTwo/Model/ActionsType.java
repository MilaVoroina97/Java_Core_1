package seminar.three.lection.taskTwo.Model;

public enum ActionsType {

    Run,
    Swim,
    Jump;

    public static ActionsType getActionType(int typeId){
        switch (typeId){
            case 1:
                return ActionsType.Jump;
            case 2:
                return ActionsType.Swim;
            case 3:
                return ActionsType.Run;
            default:
                return null;
        }
    }

}
