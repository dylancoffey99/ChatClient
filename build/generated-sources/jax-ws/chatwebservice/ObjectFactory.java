
package chatwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the chatwebservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NewSession_QNAME = new QName("http://chatwebservice/", "newSession");
    private final static QName _GetUsers_QNAME = new QName("http://chatwebservice/", "getUsers");
    private final static QName _PostMessage_QNAME = new QName("http://chatwebservice/", "postMessage");
    private final static QName _GetMessagesResponse_QNAME = new QName("http://chatwebservice/", "getMessagesResponse");
    private final static QName _LogOut_QNAME = new QName("http://chatwebservice/", "logOut");
    private final static QName _PostMulticast_QNAME = new QName("http://chatwebservice/", "postMulticast");
    private final static QName _GetUsersResponse_QNAME = new QName("http://chatwebservice/", "getUsersResponse");
    private final static QName _RegisterUserResponse_QNAME = new QName("http://chatwebservice/", "registerUserResponse");
    private final static QName _RegisterUser_QNAME = new QName("http://chatwebservice/", "registerUser");
    private final static QName _LogOutResponse_QNAME = new QName("http://chatwebservice/", "logOutResponse");
    private final static QName _NewSessionResponse_QNAME = new QName("http://chatwebservice/", "newSessionResponse");
    private final static QName _GetMulticast_QNAME = new QName("http://chatwebservice/", "getMulticast");
    private final static QName _PostMulticastResponse_QNAME = new QName("http://chatwebservice/", "postMulticastResponse");
    private final static QName _CheckLogin_QNAME = new QName("http://chatwebservice/", "checkLogin");
    private final static QName _CheckLoginResponse_QNAME = new QName("http://chatwebservice/", "checkLoginResponse");
    private final static QName _GetMessages_QNAME = new QName("http://chatwebservice/", "getMessages");
    private final static QName _GetMulticastResponse_QNAME = new QName("http://chatwebservice/", "getMulticastResponse");
    private final static QName _PostMessageResponse_QNAME = new QName("http://chatwebservice/", "postMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: chatwebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMulticast }
     * 
     */
    public GetMulticast createGetMulticast() {
        return new GetMulticast();
    }

    /**
     * Create an instance of {@link PostMulticastResponse }
     * 
     */
    public PostMulticastResponse createPostMulticastResponse() {
        return new PostMulticastResponse();
    }

    /**
     * Create an instance of {@link PostMessageResponse }
     * 
     */
    public PostMessageResponse createPostMessageResponse() {
        return new PostMessageResponse();
    }

    /**
     * Create an instance of {@link CheckLogin }
     * 
     */
    public CheckLogin createCheckLogin() {
        return new CheckLogin();
    }

    /**
     * Create an instance of {@link CheckLoginResponse }
     * 
     */
    public CheckLoginResponse createCheckLoginResponse() {
        return new CheckLoginResponse();
    }

    /**
     * Create an instance of {@link GetMessages }
     * 
     */
    public GetMessages createGetMessages() {
        return new GetMessages();
    }

    /**
     * Create an instance of {@link GetMulticastResponse }
     * 
     */
    public GetMulticastResponse createGetMulticastResponse() {
        return new GetMulticastResponse();
    }

    /**
     * Create an instance of {@link NewSession }
     * 
     */
    public NewSession createNewSession() {
        return new NewSession();
    }

    /**
     * Create an instance of {@link GetUsers }
     * 
     */
    public GetUsers createGetUsers() {
        return new GetUsers();
    }

    /**
     * Create an instance of {@link PostMessage }
     * 
     */
    public PostMessage createPostMessage() {
        return new PostMessage();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link LogOutResponse }
     * 
     */
    public LogOutResponse createLogOutResponse() {
        return new LogOutResponse();
    }

    /**
     * Create an instance of {@link NewSessionResponse }
     * 
     */
    public NewSessionResponse createNewSessionResponse() {
        return new NewSessionResponse();
    }

    /**
     * Create an instance of {@link GetMessagesResponse }
     * 
     */
    public GetMessagesResponse createGetMessagesResponse() {
        return new GetMessagesResponse();
    }

    /**
     * Create an instance of {@link LogOut }
     * 
     */
    public LogOut createLogOut() {
        return new LogOut();
    }

    /**
     * Create an instance of {@link PostMulticast }
     * 
     */
    public PostMulticast createPostMulticast() {
        return new PostMulticast();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "newSession")
    public JAXBElement<NewSession> createNewSession(NewSession value) {
        return new JAXBElement<NewSession>(_NewSession_QNAME, NewSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "getUsers")
    public JAXBElement<GetUsers> createGetUsers(GetUsers value) {
        return new JAXBElement<GetUsers>(_GetUsers_QNAME, GetUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "postMessage")
    public JAXBElement<PostMessage> createPostMessage(PostMessage value) {
        return new JAXBElement<PostMessage>(_PostMessage_QNAME, PostMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "getMessagesResponse")
    public JAXBElement<GetMessagesResponse> createGetMessagesResponse(GetMessagesResponse value) {
        return new JAXBElement<GetMessagesResponse>(_GetMessagesResponse_QNAME, GetMessagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "logOut")
    public JAXBElement<LogOut> createLogOut(LogOut value) {
        return new JAXBElement<LogOut>(_LogOut_QNAME, LogOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostMulticast }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "postMulticast")
    public JAXBElement<PostMulticast> createPostMulticast(PostMulticast value) {
        return new JAXBElement<PostMulticast>(_PostMulticast_QNAME, PostMulticast.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "getUsersResponse")
    public JAXBElement<GetUsersResponse> createGetUsersResponse(GetUsersResponse value) {
        return new JAXBElement<GetUsersResponse>(_GetUsersResponse_QNAME, GetUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "registerUserResponse")
    public JAXBElement<RegisterUserResponse> createRegisterUserResponse(RegisterUserResponse value) {
        return new JAXBElement<RegisterUserResponse>(_RegisterUserResponse_QNAME, RegisterUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "registerUser")
    public JAXBElement<RegisterUser> createRegisterUser(RegisterUser value) {
        return new JAXBElement<RegisterUser>(_RegisterUser_QNAME, RegisterUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "logOutResponse")
    public JAXBElement<LogOutResponse> createLogOutResponse(LogOutResponse value) {
        return new JAXBElement<LogOutResponse>(_LogOutResponse_QNAME, LogOutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "newSessionResponse")
    public JAXBElement<NewSessionResponse> createNewSessionResponse(NewSessionResponse value) {
        return new JAXBElement<NewSessionResponse>(_NewSessionResponse_QNAME, NewSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMulticast }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "getMulticast")
    public JAXBElement<GetMulticast> createGetMulticast(GetMulticast value) {
        return new JAXBElement<GetMulticast>(_GetMulticast_QNAME, GetMulticast.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostMulticastResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "postMulticastResponse")
    public JAXBElement<PostMulticastResponse> createPostMulticastResponse(PostMulticastResponse value) {
        return new JAXBElement<PostMulticastResponse>(_PostMulticastResponse_QNAME, PostMulticastResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "checkLogin")
    public JAXBElement<CheckLogin> createCheckLogin(CheckLogin value) {
        return new JAXBElement<CheckLogin>(_CheckLogin_QNAME, CheckLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "checkLoginResponse")
    public JAXBElement<CheckLoginResponse> createCheckLoginResponse(CheckLoginResponse value) {
        return new JAXBElement<CheckLoginResponse>(_CheckLoginResponse_QNAME, CheckLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "getMessages")
    public JAXBElement<GetMessages> createGetMessages(GetMessages value) {
        return new JAXBElement<GetMessages>(_GetMessages_QNAME, GetMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMulticastResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "getMulticastResponse")
    public JAXBElement<GetMulticastResponse> createGetMulticastResponse(GetMulticastResponse value) {
        return new JAXBElement<GetMulticastResponse>(_GetMulticastResponse_QNAME, GetMulticastResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chatwebservice/", name = "postMessageResponse")
    public JAXBElement<PostMessageResponse> createPostMessageResponse(PostMessageResponse value) {
        return new JAXBElement<PostMessageResponse>(_PostMessageResponse_QNAME, PostMessageResponse.class, null, value);
    }

}
