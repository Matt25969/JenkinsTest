Feature: User Certification
    Scenario: User is Passed
        Given that the user Vinod is given a task to clear Java certification exam
        When Vinod got 60 marks in exam
        Then Vinod is known as Java certified
        
        
    Scenario: User is passed - my version
        Given that the user Bert is given a task to clear Java certification exam
        When Bert got 61 marks in exam
        Then Bert is known as Java certified
        
    Scenario: Force to fail
      Given that the user Biff is given a task to clear Java certification exam
        When Biff got 59 marks in exam
        Then Biff is known as Java certified
    
