//package com.LeQuangHuy.API.springboot.controller;
//
//import com.LeQuangHuy.API.springboot.model.Connect;
//import com.LeQuangHuy.API.springboot.model.User;
//import com.LeQuangHuy.API.springboot.security.service.UserService;
//import com.LeQuangHuy.API.springboot.service.ConnectService;
//import jdk.jshell.Snippet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/connects")
//public class ConnectController {
//
//
//    @Autowired
//    private ConnectService connectService;
//    private UserService userService;
//
//    public ConnectController(ConnectService connectService, UserService userService) {
//
//        this.connectService = connectService;
//        this.userService = userService;
//    }
//    @GetMapping
//    public List<Connect> getConnect(@RequestParam(required = false) Long userId) {
//        if (userId != null) {
//            return connectService.findConnectByUserID(userId);
//        } else {
//            return connectService.getAllConnect();
//        }
//    }
//
//
////    @PutMapping("/{id}")
////    public ResponseEntity<Character> updateBook(@PathVariable Long id, @RequestBody Character updatedCharacter) {
////        // Call the service method to update the User
////        Optional<Character> existingCharacterOptional = characterService.getCharacterById(id);
////        if (existingCharacterOptional.isPresent()) {
////            Character existingCharacter = existingCharacterOptional.get();
////            existingCharacter.setCharacterName(updatedCharacter.getCharacterName());
////            Character savedCharacter = characterService.saveCharacter(existingCharacter);
////            return ResponseEntity.ok(savedCharacter);
////        } else {
////
////            return ResponseEntity.notFound().build();
////        }
////    }
//
//    @DeleteMapping("/{id}")
//    public void deleteConnectById(@PathVariable Long id) {
//        connectService.deleteConnectrById(id);
//    }
//    @PostMapping("/characters")
//    public ResponseEntity<Connect> createCharacter(@RequestParam Long id,
//                                                   @RequestParam String type,
//                                                   @RequestParam String status,
//                                                   @RequestParam String group_name,
//                                                   @RequestParam Long userId) {
//        // Tạo một đối tượng Connect mới
//        Connect connect = new Connect();
//        connect.setId(id);
//        connect.setType(type);
//        connect.setStatus(status);
//        connect.setGroupName(group_name);
//
//        // Tìm người dùng dựa trên user_id
//        Optional<User> userOptional = userService.getUserById(userId);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            connect.setUser(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//        // Lưu Connect vào cơ sở dữ liệu
//        Connect savedConnect = connectService.saveConnect(connect);
//
//        // Trả về Connect đã lưu trong phản hồi
//        return ResponseEntity.ok(savedConnect);
//    }
//
//}
