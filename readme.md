# Super Bomberman

//mô tả chung về trò chơi + hình ảnh preview + table of contents

![](src/main/resources/com/g10/asset/preview/preview.png)

## Cài đặt trò chơi

Sử dụng maven và plugins javafx để chạy trò chơi

```bash
mvn clean javafx:run
```

## Cách chơi
- Sử dụng các phím mũi tên để điều khiển Bomberman, nhấn SPACE để đặt bom.
- Sử dụng ENTER và các phím mũi tên để tuỳ chọn menu.
- Nhấn ESC để thoát khỏi trò chơi và chương trình.
## Các đối tượng trong game

- ![](src/main/resources/com/g10/asset/bomber/bomber_white/bomber_white_down2.png) *Bomber* là nhân vật chính của trò chơi. Bomber có thể di chuyển theo 4 hướng trái/phải/lên/xuống theo sự điều khiển của người chơi.
- ![](src/main/resources/com/g10/asset/enemy/nuts_star/nuts_star_down1.png) *Enemy* là các đối tượng mà Bomber phải tiêu diệt hết để có thể qua Level. Enemy có thể di chuyển ngẫu nhiên hoặc tự đuổi theo Bomber tùy theo loại Enemy. Các loại Enemy sẽ được mô tả cụ thể ở phần dưới.
- ![](src/main/resources/com/g10/asset/bom/bom1.png) *Bomb* là đối tượng mà Bomber sẽ đặt và kích hoạt tại các ô Grass. Khi đã được kích hoạt, Bomber và Enemy không thể di chuyển vào vị trí Bomb. Tuy nhiên ngay khi Bomber vừa đặt và kích hoạt Bomb tại ví trí của mình, Bomber có một lần được đi từ vị trí đặt Bomb ra vị trí bên cạnh. Sau khi kích hoạt 2s, Bomb sẽ tự nổ, các đối tượng *Fire* ![](src/main/resources/com/g10/asset/fire/fire_horizon3.png) được tạo ra.
- ![](src/main/resources/com/g10/asset/root/root.png) *Root* là đối tượng được đặt lên các ô Grass, không cho phép đặt Bomb lên nhưng có thể bị phá hủy bởi Bomb được đặt gần đó. Bomber và Enemy thông thường không thể di chuyển vào vị trí Root khi nó chưa bị phá hủy.

- ![](src/main/resources/com/g10/asset/portal/portal1.png)  *Portal* là đối tượng được giấu phía sau một đối tượng Brick. Khi Brick đó bị phá hủy, Portal sẽ hiện ra và nếu tất cả Enemy đã bị tiêu diệt thì người chơi có thể qua Level khác bằng cách di chuyển vào vị trí của Portal.

Các *Item* cũng được giấu phía sau Brick và chỉ hiện ra khi Brick bị phá hủy. Bomber có thể sử dụng Item bằng cách di chuyển vào vị trí của Item. Thông tin về chức năng của các Item được liệt kê như dưới đây:
- ![](src/main/resources/com/g10/asset/item/speed_up1.png)  *SpeedItem* Khi sử dụng Item này, Bomber sẽ được tăng vận tốc di chuyển thêm một giá trị thích hợp
- ![](src/main/resources/com/g10/asset/item/fire_up1.png) *FlameItem* Item này giúp tăng phạm vi ảnh hưởng của Bomb khi nổ (độ dài các Flame lớn hơn)
- ![](src/main/resources/com/g10/asset/item/bom_up1.png) *BombItem* Thông thường, nếu không có đối tượng Bomb nào đang trong trạng thái kích hoạt, Bomber sẽ được đặt và kích hoạt duy nhất một đối tượng Bomb. Item này giúp tăng số lượng Bomb có thể đặt thêm một.
- ![](src/main/resources/com/g10/asset/item/lives_up1.png) *LivesItem* Khi sử dụng Item này, Bomber sẽ được tăng thêm 1 mạng sống.
## Cây kế thừa
![](src/main/resources/com/g10/asset/preview/package.png)

![](src/main/resources/com/g10/asset/preview/package2.png)
## Menu
- Home Menu: cổng vào khi bắt đầu chạy chương trình
    + Normal Game: chế độ một người chơi
    + PVP Game: chế độ hai người chơi (updating)
    + Option Menu: tuỳ chọn mute/unmute nhạc nền và hiệu ứng âm thanh
- Color Menu: tuỳ chọn màu cho Bomberman
## Nguồn
[Asset](https://www.spriters-resource.com/snes/sbomber/)

[Sound](https://www.sounds-resource.com/snes/superbomberman/sound/35684/)

[Music](https://youtu.be/2wPZvDrQ83A)