package dev.zaryxstudios.zaryxnear.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: autogen.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JarDocGeneratorGrpc {

  private JarDocGeneratorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "JarDocGenerator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.proto.JarUploadRequest,
      dev.zaryxstudios.zaryxnear.proto.JarDocsResponse> getGenerateDocsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateDocs",
      requestType = dev.zaryxstudios.zaryxnear.proto.JarUploadRequest.class,
      responseType = dev.zaryxstudios.zaryxnear.proto.JarDocsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.proto.JarUploadRequest,
      dev.zaryxstudios.zaryxnear.proto.JarDocsResponse> getGenerateDocsMethod() {
    io.grpc.MethodDescriptor<dev.zaryxstudios.zaryxnear.proto.JarUploadRequest, dev.zaryxstudios.zaryxnear.proto.JarDocsResponse> getGenerateDocsMethod;
    if ((getGenerateDocsMethod = JarDocGeneratorGrpc.getGenerateDocsMethod) == null) {
      synchronized (JarDocGeneratorGrpc.class) {
        if ((getGenerateDocsMethod = JarDocGeneratorGrpc.getGenerateDocsMethod) == null) {
          JarDocGeneratorGrpc.getGenerateDocsMethod = getGenerateDocsMethod =
              io.grpc.MethodDescriptor.<dev.zaryxstudios.zaryxnear.proto.JarUploadRequest, dev.zaryxstudios.zaryxnear.proto.JarDocsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateDocs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.zaryxstudios.zaryxnear.proto.JarUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.zaryxstudios.zaryxnear.proto.JarDocsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JarDocGeneratorMethodDescriptorSupplier("GenerateDocs"))
              .build();
        }
      }
    }
    return getGenerateDocsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JarDocGeneratorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JarDocGeneratorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JarDocGeneratorStub>() {
        @java.lang.Override
        public JarDocGeneratorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JarDocGeneratorStub(channel, callOptions);
        }
      };
    return JarDocGeneratorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JarDocGeneratorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JarDocGeneratorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JarDocGeneratorBlockingStub>() {
        @java.lang.Override
        public JarDocGeneratorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JarDocGeneratorBlockingStub(channel, callOptions);
        }
      };
    return JarDocGeneratorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JarDocGeneratorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JarDocGeneratorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JarDocGeneratorFutureStub>() {
        @java.lang.Override
        public JarDocGeneratorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JarDocGeneratorFutureStub(channel, callOptions);
        }
      };
    return JarDocGeneratorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void generateDocs(dev.zaryxstudios.zaryxnear.proto.JarUploadRequest request,
        io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.proto.JarDocsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateDocsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service JarDocGenerator.
   */
  public static abstract class JarDocGeneratorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return JarDocGeneratorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service JarDocGenerator.
   */
  public static final class JarDocGeneratorStub
      extends io.grpc.stub.AbstractAsyncStub<JarDocGeneratorStub> {
    private JarDocGeneratorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JarDocGeneratorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JarDocGeneratorStub(channel, callOptions);
    }

    /**
     */
    public void generateDocs(dev.zaryxstudios.zaryxnear.proto.JarUploadRequest request,
        io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.proto.JarDocsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateDocsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service JarDocGenerator.
   */
  public static final class JarDocGeneratorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<JarDocGeneratorBlockingStub> {
    private JarDocGeneratorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JarDocGeneratorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JarDocGeneratorBlockingStub(channel, callOptions);
    }

    /**
     */
    public dev.zaryxstudios.zaryxnear.proto.JarDocsResponse generateDocs(dev.zaryxstudios.zaryxnear.proto.JarUploadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateDocsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service JarDocGenerator.
   */
  public static final class JarDocGeneratorFutureStub
      extends io.grpc.stub.AbstractFutureStub<JarDocGeneratorFutureStub> {
    private JarDocGeneratorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JarDocGeneratorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JarDocGeneratorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.zaryxstudios.zaryxnear.proto.JarDocsResponse> generateDocs(
        dev.zaryxstudios.zaryxnear.proto.JarUploadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateDocsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_DOCS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_DOCS:
          serviceImpl.generateDocs((dev.zaryxstudios.zaryxnear.proto.JarUploadRequest) request,
              (io.grpc.stub.StreamObserver<dev.zaryxstudios.zaryxnear.proto.JarDocsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGenerateDocsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dev.zaryxstudios.zaryxnear.proto.JarUploadRequest,
              dev.zaryxstudios.zaryxnear.proto.JarDocsResponse>(
                service, METHODID_GENERATE_DOCS)))
        .build();
  }

  private static abstract class JarDocGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JarDocGeneratorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dev.zaryxstudios.zaryxnear.proto.Autogen.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JarDocGenerator");
    }
  }

  private static final class JarDocGeneratorFileDescriptorSupplier
      extends JarDocGeneratorBaseDescriptorSupplier {
    JarDocGeneratorFileDescriptorSupplier() {}
  }

  private static final class JarDocGeneratorMethodDescriptorSupplier
      extends JarDocGeneratorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    JarDocGeneratorMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JarDocGeneratorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JarDocGeneratorFileDescriptorSupplier())
              .addMethod(getGenerateDocsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
