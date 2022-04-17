import tkinter as tk


class Window:
    def __init__(self):
        self.window = tk.Tk()

    def Button(self):
        # add widgets here

        self.window.title('Choise')
        self.window.geometry("300x300")

        buttonRegister = tk.Button(self.window, text="Register", command=self.Register)
        buttonConnect = tk.Button(self.window, text="Login", command=self.Connect)
        buttonRegister.place(x=100, y=100)
        buttonConnect.place(x=200, y=100)

        self.window.mainloop()

    def Register(self):
        self.window.destroy()
        self.window = tk.Tk()
        # add widgets here

        self.window.title('AppDesk')
        self.window.geometry("300x300")
        labelNameWindow = tk.Label(self.window, text="Register", font=("Arial", 20))
        labelNameWindow.place(x=80, y=40)
        labelName = tk.Label(self.window, text="Username")
        labelName.place(x=80, y=80)
        userRegisterName = tk.Entry(self.window, bd=5)
        userRegisterName.place(x=80, y=100)
        labelPassword = tk.Label(self.window, text="Password")
        labelPassword.place(x=80, y=130)
        userRegisterPassword = tk.Entry(self.window, bd=5)
        userRegisterPassword.place(x=80, y=150)
        labelPasswordR = tk.Label(self.window, text="Confirm Password")
        labelPasswordR.place(x=80, y=180)
        userRegisterPasswordR = tk.Entry(self.window, bd=5)
        userRegisterPasswordR.place(x=80, y=200)

        buttonRegister = tk.Button(self.window, text="Intregistreaza-te! Da Baby!!", command=self.Creez)
        buttonRegister.place(x=80, y=250)

        self.window.mainloop()
        self.window.destroy()

    def Connect(self):
        self.window.destroy()
        self.window = tk.Tk()
        # add widgets here

        self.window.title('Connect')
        self.window.geometry("300x300")
        labelNameWindow = tk.Label(self.window, text="Connect", font=("Arial", 20))
        labelNameWindow.place(x=80, y=40)

        userConnectLabel = tk.Label(self.window, text="Username")
        userConnectLabel.place(x=80, y=80)
        userConnectName = tk.Entry(self.window, bd=5)
        userConnectName.place(x=80, y=100)
        userConnectLabel = tk.Label(self.window, text="Password")
        userConnectLabel.place(x=80, y=130)
        userConnectPassword = tk.Entry(self.window, bd=5)
        userConnectPassword.place(x=80, y=150)

        buttonConnect = tk.Button(self.window, text="Daaa! Ma conectez", command=self.Conexiune)
        buttonConnect.place(x=60, y=200)
        buttonRegister = tk.Button(self.window, text="Go to register", command=self.Register)
        buttonRegister.place(x=60,y=250)

        self.window.mainloop()

    def Creez(self):
        self.window.destroy()
        self.window = tk.Tk()
        # add widgets here
        # aici trebuie sa luam textul si sa il bagam in BD

        self.window.title('AppDesk')
        self.window.geometry("300x300")

        labelTextPass = tk.Label(self.window, text="Contul s-a creat", font=("Arial", 20))
        labelTextPass.place(x=50, y=100)

        buttonClose = tk.Button(self.window, text="Login", command=self.Connect)
        buttonClose.place(x=200, y=200)

        self.window.mainloop()
        self.window.destroy()

    def Conexiune(self):
        self.window.destroy()
        window = tk.Tk()
        # add widgets here
        # aici trebuie sa luam user si pass si facem conexiune efectiva

        window.title('AppDesk')
        window.geometry("300x300")

        #aici conmexiune
        labelTextPass = tk.Label(window, text="Conexiune pass", font=("Arial", 20))
        labelTextPass.place(x=20, y=100)
        #redirect?
        #buttonClose = tk.Button(self.window, text="Close", command=self.Close)
        #buttonClose.place(x=200, y=200)

        window.mainloop()

if __name__ == '__main__':
    win = Window()
    win.Button()
