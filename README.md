# BankAnalyzer
https://github.com/serdyuksb1982/bankTransaction

Raoul-Gabriel Urma, Richard Warburton "Real-World Software Development"

Тип связности                                  Плюсы                            Минусы                                       
                       
                                                                   
функциональная (высокая связность):    Легко читается                 Может привести к избытку чересчур простых классов      

                                                                                                                             
Информационная (средняя связность):     Легко обслуживается            Может привести к ненужным зависимостям                 

                                                                                                                             
Последовательная (средняя):             Легко обнаружить                                                                      
                                       связанные операции               Не соблюдается принцип SRP                          

                                                                                                                              
Логическая (средняя связность):         Обеспечивает определенный         Не соблюдает принцип SRP                            
                                       тип сильной категоризации                                                             

Служебная (слабая связность):           Легко организовать                Тяжело понять назначение класса                         
 
          
Временная (слабая связность):           Нет                           Тяжело различить и использовать отдельные операции                                      
