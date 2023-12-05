package ra.session06_btlt.mapper;

public interface GenericMapper <E,T,U>{
    //E:Entity,T:Request,U:Response
    //1.Phương thức chuyển đổi từ RequestDTO---->Entity
    E toEntity(T t);
    //2.Phương thức chuyển đổi từ Entity---->ResponseDTO
    U toResponse(E e);
}
