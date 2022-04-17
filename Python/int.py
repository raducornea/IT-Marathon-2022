import tkinter as tk
import tkinter.ttk

import  requests as rq

thisdict = {}


class Window:
    def __init__(self):
        self.window = tk.Tk()
        self.userRegisterName = tk.Entry(self.window, bd=5)
        self.userRegisterPassword = tk.Entry(self.window, bd=5, show="*")
        self.userRegisterPasswordR = tk.Entry(self.window, bd=5, show="*")
        self.userConnectName = tk.Entry(self.window, bd=5)
        self.userConnectPassword = tk.Entry(self.window, bd=5, show="*")
        self.admin = False

    def Button(self):
        # add widgets here
        self.window.title('AppDesk')
        self.window.geometry("300x300")

        textAlegere = tk.Label(self.window, text="Choise a option", font=('Tahoma', 20))
        textAlegere.place(x=50, y=50)

        buttonRegister = tk.Button(self.window, text="Register", command=self.Register)
        buttonConnect = tk.Button(self.window, text="Login", command=self.Login)
        buttonRegister.place(x=120, y=100)
        buttonConnect.place(x=125, y=150)

        self.window.mainloop()

    def Register(self):
        self.window = tk.Tk()
        # add widgets here

        self.window.title('AppDesk')
        self.window.geometry("300x300")
        labelNameWindow = tk.Label(self.window, text="Register", font=("Arial", 20))
        labelNameWindow.place(x=90, y=40)

        labelName = tk.Label(self.window, text="Username")
        labelName.place(x=80, y=80)
        self.userRegisterName = tk.Entry(self.window, bd=5)
        self.userRegisterName.place(x=80, y=100)

        labelPassword = tk.Label(self.window, text="Password")
        labelPassword.place(x=80, y=130)
        self.userRegisterPassword = tk.Entry(self.window, bd=5, show="*")
        self.userRegisterPassword.place(x=80, y=150)

        labelPasswordR = tk.Label(self.window, text="Confirm Password")
        labelPasswordR.place(x=80, y=180)
        self.userRegisterPasswordR = tk.Entry(self.window, bd=5, show="*")
        self.userRegisterPasswordR.place(x=80, y=200)

        admin = tk.Entry(self.window)
        admin.place(x=80, y=230)
        if admin == 'd':
            self.admin = True
        buttonRegister = tk.Button(self.window, text="Inregistreaza-te! Da Baby!!", command=self.intregistrareUser)
        buttonRegister.place(x=75, y=270)

        self.window.mainloop()

    def Login(self):

        self.window = tk.Tk()
        # add widgets here

        self.window.title('Connect')
        self.window.geometry("300x300")
        labelNameWindow = tk.Label(self.window, text="Connect", font=("Arial", 20))
        labelNameWindow.place(x=90, y=30)

        userConnectLabel = tk.Label(self.window, text="Username")
        userConnectLabel.place(x=80, y=60)
        self.userConnectName = tk.Entry(self.window, bd=5)
        self.userConnectName.place(x=80, y=80)
        userConnectLabel = tk.Label(self.window, text="Password")
        userConnectLabel.place(x=80, y=100)
        self.userConnectPassword = tk.Entry(self.window, bd=5, show="*")
        self.userConnectPassword.place(x=80, y=120)
        buttonConnect = tk.Button(self.window, text="Daaa! Ma conectez", command=self.creezConexiune)
        buttonConnect.place(x=90, y=200)
        buttonRegister = tk.Button(self.window, text="Go to register", command=self.Register)
        buttonRegister.place(x=110, y=230)

        self.window.mainloop()

    def intregistrareUser(self):
        self.window = tk.Tk()
        # add widgets here
        # aici trebuie sa luam textul si sa il bagam in BD

        self.window.title('AppDesk')
        self.window.geometry("300x300")

        # TO DO -> campuri goale
        newUser = self.userRegisterName.get()
        newPass = self.userRegisterPassword.get()
        verifyPass = self.userRegisterPasswordR.get()
        print(self.admin)
        if newPass == verifyPass:
            thisdict[newUser] = newPass
            print(thisdict)
            r = rq.post(f'http://localhost:6480/user?userName={newUser}&password={newPass}')
            labelTextPass = tk.Label(self.window, text="Contul s-a creat", font=("Arial", 20))
            labelTextPass.place(x=50, y=100)
            buttonClose = tk.Button(self.window, text="Login", command=self.Login)
            buttonClose.place(x=200, y=200)
        else:
            labelTextPass = tk.Label(self.window, text="Ceva nu a mers bine", font=("Arial", 20))
            labelTextPass.place(x=20, y=100)
            buttonClose = tk.Button(self.window, text="Reload", command=self.Button)
            buttonClose.place(x=200, y=200)

        self.window.mainloop()

    def creezConexiune(self):
        window = tk.Tk()
        # add widgets here
        # aici trebuie sa luam user si pass si facem conexiune efectiva

        window.title('AppDesk')
        window.geometry("300x300")
        flag = False
        # aici conmexiune
        userName = self.userConnectName.get()
        userPass = self.userConnectPassword.get()
        print(self.admin)
        for cheie in thisdict.keys():
            if cheie == userName and thisdict[cheie] == userPass:
                labelTextPass = tk.Label(window, text="Conexiune pass", font=("Arial", 20))
                labelTextPass.place(x=20, y=100)
            else:
                labelTextPass = tk.Label(window, text="Reject", font=("Arial", 20))
                labelTextPass.place(x=80, y=100)
        # redirect?
        # buttonClose = tk.Button(self.window, text="Close", command=self.Close)
        # buttonClose.place(x=200, y=200)
        window.mainloop()

    def allClose(self):
        self.window.destroy()


class Admin:

    def __init__(self):
        self.interface = tk.Tk()
        self.applicationNameEntry = tk.Entry()
        self.data = tk.Text()

        self.deviceName = tk.Entry()
    def adminInterface(self):
        self.interface.title('DevelopMap')
        self.interface.geometry("800x300")

        applicationNameLabel = tk.Label(self.interface, text="applicatione name", font=("Arial", 10))
        applicationNameLabel.place(x=10, y=10)
        self.applicationNameEntry = tk.Entry(self.interface, width=40, bd=5)
        self.applicationNameEntry.place(x=120, y=10)
        labelData = tk.Label(self.interface, text="date", font=("Arial", 10))
        labelData.place(x=10, y=40)
        self.data = tk.Text(self.interface, height=10, width=25)
        self.data.place(x=50, y=40)

        labelName = tk.Label(self.interface, text="name device", font=("Arial", 10))
        labelName.place(x=0, y=220)

        self.deviceName = tk.Entry(self.interface, width=40, bd=5)
        self.deviceName.place(x=80, y=220)

        buttonAdd = tk.Button(self.interface, text="Add App",width=20, command=self.ADD_app)
        buttonAdd.place(x=10, y=250)

        buttonUpdate = tk.Button(self.interface, text="Update", width=20, command=self.UPDATE)
        buttonUpdate.place(x=200, y=250)

        columns = ('id', 'App name')
        tree = tkinter.ttk.Treeview(self.interface,columns=columns, show='headings')
        tree.heading('id', text='id')
        tree.heading('App name', text='name')
        tree.place(x=380, y=0)

        buttonGetApp = tk.Button(self.interface, text="Get App", width=20, command=self.GET)
        buttonGetApp.place(x=400, y=250)

        buttonADDDevice = tk.Button(self.interface, text="Add Device", width=10, command=self.ADD_Device)
        buttonADDDevice.place(x=600, y=250)

        self.interface.mainloop()

    def ADD_app(self):
        r = rq.post(f'http://localhost:6480/application?name={self.applicationNameEntry.get()}&data={self.data.get("1.0", "end")}')

    def UPDATE(self):
        pass

    def GET(self):
        pass

    def ADD_Device(self):
        r = rq.post(f'http://localhost:6480/device?deviceName={self.deviceName.get()}&userId={1}')


if __name__ == '__main__':
    n = input()
    if n == '1':
        win = Window()
        win.Button()
        win.allClose()
    if n == '2':
        admin = Admin()
        admin.adminInterface()
    

