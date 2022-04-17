import tkinter as tk


def Button():
    window = tk.Tk()
    # add widgets here

    window.title('Choise')
    window.geometry("300x300")

    buttonRegister = tk.Button(window, text="Register", command=Register)
    buttonConnect = tk.Button(window, text="Connect", command=Connect)
    buttonRegister.place(x=100, y=100)
    buttonConnect.place(x=200, y=100)

    window.mainloop()
    window.destroy()



def Register():
    window = tk.Tk()
    # add widgets here

    window.title('AppDesk')
    window.geometry("300x300")
    labelNameWindow = tk.Label(window, text="Register", font=("Arial", 20))
    labelNameWindow.place(x=80, y=40)
    labelName = tk.Label(window, text="Username")
    labelName.place(x=80, y=80)
    userRegisterName = tk.Entry(window, bd=5)
    userRegisterName.place(x=80, y=100)
    labelPassword = tk.Label(window, text="Password")
    labelPassword.place(x=80, y=130)
    userRegisterPassword = tk.Entry(window, bd=5)
    userRegisterPassword.place(x=80, y=150)
    labelPasswordR = tk.Label(window, text="Confirm Password")
    labelPasswordR.place(x=80, y=180)
    userRegisterPasswordR = tk.Entry(window, bd=5)
    userRegisterPasswordR.place(x=80, y=200)

    buttonRegister = tk.Button(window, text="Intregistreaza-te! Da Baby!!", command=Creez)
    buttonRegister.place(x=80,y=250)

    window.mainloop()
    window.destroy()


def Connect():
    window = tk.Tk()
    # add widgets here

    window.title('Connect')
    window.geometry("300x300")
    labelNameWindow = tk.Label(window, text="Connect", font=("Arial", 20))
    labelNameWindow.place(x=80, y=40)

    userConnectLabel = tk.Label(window, text="Username")
    userConnectLabel.place(x=80, y=80)
    userConnectName = tk.Entry(window, bd=5)
    userConnectName.place(x=80, y=100)
    userConnectLabel = tk.Label(window, text="Password")
    userConnectLabel.place(x=80, y=130)
    userConnectPassword = tk.Entry(window, bd=5)
    userConnectPassword.place(x=80, y=150)

    buttonConnect = tk.Button(window, text="Daaa! Ma conectez", command=Conexiune)
    buttonConnect.place(x=80, y=200)

    window.mainloop()
    window.destroy()
def Creez():
    window = tk.Tk()
    # add widgets here
    #aici trebuie sa luam textul si sa il bagam in BD

    window.title('AppDesk')
    window.geometry("300x300")

    labelTextPass = tk.Label(window,text="Contul s-a creat",font=("Arial", 40))
    labelTextPass.place(x=100,y=100)


    window.mainloop()
    window.destroy()

def Conexiune():
    window = tk.Tk()
    # add widgets here
    # aici trebuie sa luam user si pass si facem conexiune efectiva

    window.title('AppDesk')
    window.geometry("300x300")

    labelTextPass = tk.Label(window, text="Conexiune pass", font=("Arial", 40))
    labelTextPass.place(x=100, y=100)

    window.mainloop()
    window.destroy()

if __name__ == '__main__':
    Button()
    Connect()
    Register()
