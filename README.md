# Hands-on exercises for OOP course at HUST
## Student info
Name: Hoàng Trần Nhật Minh \
Student ID: 20204883

## Notes
- Lab01: Done
- Lab02: Done
- Lab03: Done
- Lab04:
  - Note: The computers in room D5-305 are too slow to run Eclipse so I guess I cannot turn in for this deadline.
  - Note: Instead of naming the package like `hust.soict.dsai.test.cart`, I named it like `hust.soict.dsai.aims.test.cart`, and so on for sibling packages. The reason why:
    - Before: ![image](https://user-images.githubusercontent.com/82358580/169690961-e2c4652c-23b1-4fbc-8d1c-25b5cf78603a.png) -> After: ![image](https://user-images.githubusercontent.com/82358580/169691055-a59af517-97e2-4f61-a6f7-54da4f51bca5.png)


  - Answers (I will move it later):
    - Is JAVA a Pass by Value or a Pass by Reference programming language?
      - Java is pass by value. Even for objects, we are working with references of those objects, which are pass by value.
    - After the call of swap(jungleDVD, cinderellaDVD) why does the title of these two objects still remain?
      - The method swap() creates copies of those references, so swap those copies changes nothing.
    - After the call of changeTitle(jungleDVD, cinderellaDVD.getTitle()) why is the title of the JungleDVD changed?
      - The method changeTitle() sets the new title for the referenced object. Afterwards, it tries to assign the dvd to a new dvd with the old title, but it does nothing since dvd is just a copy of reference.
    

# Docs
- [LICENSE](https://github.com/htnminh/OOP.20212.20204883.HoangTranNhatMinh/blob/e28d30c74dcecc91b12979f0d0f9e7d4c4b4fff8/LICENSE)
- [Code of Conduct](https://github.com/htnminh/OOP.20212.20204883.HoangTranNhatMinh/blob/e28d30c74dcecc91b12979f0d0f9e7d4c4b4fff8/docs/CODE_OF_CONDUCT.md)
- [Contributing](https://github.com/htnminh/OOP.20212.20204883.HoangTranNhatMinh/blob/e28d30c74dcecc91b12979f0d0f9e7d4c4b4fff8/docs/CONTRIBUTING.md)
- [Issue templates](https://github.com/htnminh/OOP.20212.20204883.HoangTranNhatMinh/tree/main/.github/ISSUE_TEMPLATE)

<!---
# Name
Description

Links to related repos

![preview](https://github.com/htnminh/python-template/blob/main/docs/preview.png)

List of good files in repo:
- []()
- []()
- []()

## Chapter 1:
Quick introduction about the chapter
## Chapter 2:
Quick introduction about the chapter
## Chapter 3:
Quick introduction about the chapter


-->
