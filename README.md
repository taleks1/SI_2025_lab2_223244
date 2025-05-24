# SI_2025_lab2_223244
Александра Трпчевска 223244

2.  Control Flow Graph
   ![CFG](https://github.com/user-attachments/assets/88fedc84-9e9e-43ff-9f44-3e8d2e38c38f)

3.  Цикломатската комплексност
Цикломатската комплексност е 9. се пресметува на два начини:
   - бр.на ребра-бр.на јазли+2=34-27+2=9
   -се бројат регионите во графикот=9

4. минимално терба да се поминат 5 теста. обработени се во табелата според Every Statement критериумот.
прв: се прака празна низа односно вредноста на итемс има вредност нулл и тука доага до фрланје на првиот исклучок.
се поминуваат само 1,2 и 23
![image](https://github.com/user-attachments/assets/e6f9d388-f46a-43b3-ac10-6fb0bf14fe43)

втор:Создаваме листа со еден Item кој има null за name.
се поминуваат редовите: 1,3,4.1,4.2,5,6,7
![image](https://github.com/user-attachments/assets/95d82091-345f-401f-8132-562bbba9c5f3)

трет:Item со discount > 0, price <= 300, quantity <= 10, валидна картичка
Овој тест покрива гранка кога discount > 0 (линија 10-11), и не се активира sum -= 30 (линија 9) затоа што условите не се исполнети.
![image](https://github.com/user-attachments/assets/1e6ba69a-42e8-44d8-8938-a13cd6466512)

четврти: Item со discount == 0, price <= 300, quantity <= 10
![image](https://github.com/user-attachments/assets/60e5f651-8ab6-4aa9-9a23-1723256d043c)

петти:Item со price > 300 (активација на sum -= 30), и невалидна картичка 

![image](https://github.com/user-attachments/assets/7d1f9e07-de4a-4b81-a247-d0bc6a68ba0f)

 ![image](https://github.com/user-attachments/assets/22a2d49a-3871-44f6-9edd-2f1f2d949b37)

5. Multiple Condition критериумот за условот
if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
треба да се изврсат најмалку 2^3=8 бидејки има 3 ставки во условот
на сликата е прикжано решението со овој критериум за условот. потребно е само една вреднос да e true  за целиот услов да е true.
![image](https://github.com/user-attachments/assets/83968d8e-63f7-4606-b3f3-749438e8dd5d)
